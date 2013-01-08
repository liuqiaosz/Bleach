
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author LiuQiao
 */
public class Test
{

    public static void main(String[] args)
    {
        try
        {
            fileTest();
        }
        catch (Exception ex)
        {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void fileTest()throws Exception
    {
        File file = new File("/Users/LiuQiao/Downloads/apache-mina-2.0.7/LICENSE.txt");
        int len = (int) file.length();
        byte[] data = new byte[len];
        int readSeek = 0;
        int size = 0;
        //传统读取
        byte[] buffer = new byte[1024];
        FileInputStream reader = new FileInputStream(file);

        while ((size = reader.read(buffer)) != -1)
        {
            System.arraycopy(buffer, 0, data, readSeek, size);
            readSeek += size;
            if (readSeek == len)
            {
                File newfile = new File("/Users/LiuQiao/Downloads/apache-mina-2.0.7/copy.txt");
                newfile.createNewFile();
                FileOutputStream out = new FileOutputStream(newfile);
                out.write(data);
                out.flush();
                out.close();
                System.out.println("!!!");
            }
        }
    }
}
