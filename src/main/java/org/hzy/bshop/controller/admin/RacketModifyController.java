package org.hzy.bshop.controller.admin;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.hzy.bshop.entity.Racket;
import org.hzy.bshop.mapper.RacketMapper;
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

@WebServlet("/adminRacketModify")
public class RacketModifyController extends HttpServlet {

    private DiskFileItemFactory factory;
    private ServletFileUpload upload;
    private RacketMapper racketMapper;

    {
        factory = new DiskFileItemFactory();
        upload = new ServletFileUpload(factory);
        racketMapper = MyBatisUtil.getSqlSession().getMapper(RacketMapper.class);
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
        Racket racket = new Racket();
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
                    if(fieldName.equals("id")){
                        racket.setId(Integer.parseInt(fieldValue));
                    }
                    if(fieldName.equals("name")){
                        racket.setName(fieldValue);
                    }
                    if(fieldName.equals("description")){
                        racket.setDescription(fieldValue);
                    }
                    if(fieldName.equals("appraise")){
                        racket.setAppraise(Double.parseDouble(fieldValue));
                    }
                    if(fieldName.equals("price")){
                        racket.setPrice(Double.parseDouble(fieldValue));
                    }
                    if(fieldName.equals("stock")){
                        racket.setStock(Integer.parseInt(fieldValue));
                    }
                    if(fieldName.equals("brandId")){
                        racket.setBrandId(Integer.parseInt(fieldValue));
                    }
                    if(fieldName.equals("seriesId")){
                        racket.setSeriesId(Integer.parseInt(fieldValue));
                    }
                    if(fieldName.equals("handleId")){
                        racket.setHandleId(Integer.parseInt(fieldValue));
                    }
                    if(fieldName.equals("weightId")){
                        racket.setWeightId(Integer.parseInt(fieldValue));
                    }
                    if(fieldName.equals("placeId")){
                        racket.setPlaceId(Integer.parseInt(fieldValue));
                    }
                    if(fieldName.equals("cImagePath")){

                            new File(uploadFileDir+"/"+fieldValue).delete();


                    }
                }
                // 如果是文件上传域
                if(!fileItem.isFormField()){
                    String fieldName = fileItem.getFieldName();
                    String fieldValue = fileItem.getString("UTF-8");
                    if(fieldName.equals("imagePath")) {
                        if (fieldValue.length() != 0) {
                            String uploadFileName = UUID.randomUUID().toString() + fileItem.getName().substring(fileItem.getName().lastIndexOf("."));
                            // 设置产品的图片路径
                            racket.setImagePath("/" + uploadFileName);
                            File uploadFile = new File(uploadFileDir, uploadFileName);
                            InputStream is = fileItem.getInputStream();
                            FileOutputStream fos = new FileOutputStream(uploadFile);
                            byte[] bytes = new byte[1024 * 4];
                            int length = 0;
                            while ((length = is.read(bytes)) != -1) {
                                fos.write(bytes, 0, length);
                            }
                            is.close();
                            fos.close();
                        }
                    }
                }
            }
            racket.setIsDeteled(false);
            racketMapper.updateByPrimaryKeySelective(racket);
            response.sendRedirect("/adminRacket?method=list");
        }
        catch (Exception e) {
            e.printStackTrace();
        }


    }
}
