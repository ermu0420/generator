package com.ermu.generator;

import com.ermu.generator.entity.IdcReProduct;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

/**
 * @author：xusonglin
 * ===============================
 * Created with IDEA.
 * Date：2019/1/14
 * Time：14:01
 * ================================
 */
@Component
public class DataInit implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        initTableComment();
    }
    /**
     * 执行sql语句
     * @param sql
     */
    private void executeSql(String sql) {
        System.out.println(sql);
    }

    /**
     * 获得包下面的所有的class
     *
     * @param
     *
     * @return List包含所有class的实例
     */

    public static List<Class<?>> getClasssFromPackage(String packageName) {
        List<Class<?>> clazzs = new ArrayList<>();
        // 是否循环搜索子包
        boolean recursive = true;
        // 包名对应的路径名称
        String packageDirName = packageName.replace('.', '/');
        Enumeration<URL> dirs;

        try {
            dirs = Thread.currentThread().getContextClassLoader().getResources(packageDirName);
            while (dirs.hasMoreElements()) {
                URL url = dirs.nextElement();
                String protocol = url.getProtocol();
                if ("file".equals(protocol)) {
                    String filePath = URLDecoder.decode(url.getFile(), "UTF-8");
                    findClassInPackageByFile(packageName, filePath, recursive, clazzs);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clazzs;
    }

    /**
     * 在package对应的路径下找到所有的class
     */
    public static void findClassInPackageByFile(String packageName, String filePath, final boolean recursive,
                                                List<Class<?>> clazzs) {
        File dir = new File(filePath);
        if (!dir.exists() || !dir.isDirectory()) {
            return;
        }
        // 在给定的目录下找到所有的文件，并且进行条件过滤
        File[] dirFiles = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                // 接受dir目录
                boolean acceptDir = recursive && file.isDirectory();
                // 接受class文件
                boolean acceptClass = file.getName().endsWith("class");
                return acceptDir || acceptClass;
            }
        });
        for (File file : dirFiles) {
            if (file.isDirectory()) {
                findClassInPackageByFile(packageName + "." + file.getName(), file.getAbsolutePath(), recursive, clazzs);
            } else {
                String className = file.getName().substring(0, file.getName().length() - 6);
                try {
                    clazzs.add(Thread.currentThread().getContextClassLoader().loadClass(packageName + "." + className));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /**
     * 初始化表字段注释
     */
    private void initTableComment() {
        StringBuilder builder = new StringBuilder();
        // 获取特定包下所有的类
        List<Class<?>> clsList = getClasssFromPackage("com.ermu.generator.entity");
        if (!CollectionUtils.isEmpty(clsList)) {
            for (Class<?> cls : clsList) {
                // 选出包含注解@Entity和@Table的类
                if (cls.isAnnotationPresent(Entity.class) && cls.isAnnotationPresent(Table.class)) {
                    Table table = cls.getAnnotation(Table.class);
                    Field[] fields = cls.getDeclaredFields();
                    if(cls.isAnnotationPresent(ApiModel.class)){
                        ApiModel comment = cls.getAnnotation(ApiModel.class);
                        String sql = "COMMENT ON TABLE " + table.name()  + " is '" + comment.value() + "';";
                        executeSql(sql);
                    }
                    if (null != fields && fields.length > 0) {
                        for (Field field : fields) {
                            // 选出包含注解@Comment和@Column的类
                            if (field.isAnnotationPresent(ApiModelProperty.class) && field.isAnnotationPresent(Column.class)) {
                                ApiModelProperty comment = field.getAnnotation(ApiModelProperty.class);
                                Column column = field.getAnnotation(Column.class);
                                String sql = "comment on column " + table.name() + "." + column.name() + " is '" + comment.value() + "';";
                                executeSql(sql);
                            }
                        }
                    }
                }
            }
        }
        System.out.println(builder.toString());
    }
 }

