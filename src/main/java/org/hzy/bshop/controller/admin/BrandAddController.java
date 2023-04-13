package org.hzy.bshop.controller.admin;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.hzy.bshop.entity.Brand;
import org.hzy.bshop.mapper.BrandMapper;
import org.hzy.bshop.util.MyBatisUtil;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

@WebServlet("/adminBrandAdd")
public class BrandAddController extends HttpServlet {

    private DiskFileItemFactory factory;
    private ServletFileUpload upload;
    private BrandMapper brandMapper;

    {
        factory = new DiskFileItemFactory();
        upload = new ServletFileUpload(factory);
        brandMapper = MyBatisUtil.getSqlSession().getMapper(BrandMapper.class);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 找到上传的目录 /images
        // 获取项目的跟目录
        String appPath = request.getServletContext().getRealPath("/");
        // 获得文件上传目录
        File uploadFileDir = new File(appPath+"/images");
        // 文件上传目录是否存在的判断
        if(!uploadFileDir.exists()){
            uploadFileDir.mkdirs();
        }
        Brand brand = new Brand();
        List<FileItem> itemList;
        try {
            // 用户填写或者选择信息的封装域
            itemList = upload.parseRequest(request);
            for(FileItem fileItem:itemList){
                // 如果是普通文本域
                if(fileItem.isFormField()){
                    String fieldName = fileItem.getFieldName();
                    String fieldValue = fileItem.getString("UTF-8");
                    System.out.println("fieldName="+fieldName+",fieldValue="+fieldValue);
                    if(fieldName.equals("name")){
                        brand.setName(fieldValue);
                    }
                    if(fieldName.equals("description")){
                        brand.setDescription(fieldValue);
                    }
                }
                // 如果是文件上传域
                if(!fileItem.isFormField()){
                    String fieldName = fileItem.getFieldName();
                    if(fieldName.equals("imagePath")){
                        String uploadFileName = UUID.randomUUID().toString()+fileItem.getName().substring(fileItem.getName().lastIndexOf("."));
                        // 设置产品的图片路径
                        brand.setTmPath("/"+uploadFileName);
                        File uploadFile = new File(uploadFileDir,uploadFileName);
                        InputStream is = fileItem.getInputStream();
                        FileOutputStream fos = new FileOutputStream(uploadFile);
                        byte[] bytes = new byte[1024*4];
                        int length = 0;
                        while((length=is.read(bytes))!=-1){
                            fos.write(bytes,0,length);
                        }
                        is.close();
                        fos.close();
                    }
                }
            }
            brand.setIsDeleted(false);
            brandMapper.insertSelective(brand);
            response.sendRedirect("/adminBrand?method=list");
        }
        catch (Exception e) {
            e.printStackTrace();
        }


    }
}
