package com.openfaas.function;

import com.openfaas.model.IHandler;
import com.openfaas.model.IResponse;
import com.openfaas.model.IRequest;
import com.openfaas.model.Response;
import java.io.*;
import java.util.*;
import java.awt.image.*;

import javax.imageio.*;
import javax.imageio.stream.ImageOutputStream;


public class Handler extends com.openfaas.model.AbstractHandler  {
    
    public IResponse Handle(IRequest req) {
      try{
        long start1 = System.nanoTime();
    ClassLoader cLoader = Thread.currentThread().getContextClassLoader();
         
         
      InputStream input = cLoader.getSystemResourceAsStream("image.jpg");
      BufferedImage image = ImageIO.read(input);

      File compressedImageFile = new File("compress.jpg");

      OutputStream os =new FileOutputStream(compressedImageFile);

      Iterator<ImageWriter>writers =  ImageIO.getImageWritersByFormatName("jpg");
      ImageWriter writer = (ImageWriter) writers.next();

      ImageOutputStream ios = ImageIO.createImageOutputStream(os);
      writer.setOutput(ios);

      ImageWriteParam param = writer.getDefaultWriteParam();
      
      param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
      param.setCompressionQuality(0.05f);
      writer.write(null, new IIOImage(image, null, null), param);
      
      os.close();
      ios.close();
      writer.dispose();
      long end1 = System.nanoTime();     
        Response res = new Response();
	    res.setBody("Hello, world mama__!"+(end1-start1));

	    return res;
      }
      catch(Exception e)
      {
        ;
        Response res = new Response();
	    res.setBody(e.toString()+"yo_16");
        return res;
      }
    }
}
