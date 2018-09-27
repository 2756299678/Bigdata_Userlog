package com.utils;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.util.Progressable;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

public class HDFSFileUtil {
    static Configuration conf;
    static FileSystem filesystem;
    static String DEFNAME="fs.defaultFS";
    static String HDFSURL="hdfs://192.168.72.10:9000";
    @Before
    public void before() throws IOException {
        conf=new Configuration();
        conf.set(DEFNAME, HDFSURL);
        filesystem=FileSystem.get(conf);
    }

    /**
     * junit测试函数
     * @throws IOException
     */
    @Test
    public void Text() throws Exception {
        //创建目录
        //mkdir("/idea/");

        //创建文件
        //create("/idea/haha.txt");

        //查看hdfs文件内容
        //read("/idea/text.txt");

        //文件重命名
        //moveFile("/idea/haha.txt","/idea/hello.txt");

        //上传文件
       // putFile("G://text.txt","/idea/");

        //下载文件
        //getFile("/idea/abc.txt","G://");

        //查询目录下的所有文件
        //listStatus("/idea/");

        //删除文件
        //deleteFile("/idea/hello.txt");

        //putfilebar();
    }
    
    /**
     * 创建目录
     * @param path 创建目录的地址（例：/hadoop/）
     * @throws IOException
     */
    public boolean ifExit(String path) throws Exception {
        //创建hdfs目录
        if(filesystem.exists(new Path(path)))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * 创建目录
     * @param path 创建目录的地址（例：/hadoop/）
     * @throws IOException
     */
    public void mkdir(String path) throws IOException {
        //创建hdfs目录
        if(filesystem.exists(new Path(path)))
        {
            System.out.println("目录已存在");
        }
        else
        {
            boolean result=filesystem.mkdirs(new Path(path));
            System.out.println(result);
        }
    }

    /**
     * 创建文件
     * @param path hdfs文件地址(例：/hadoop/abc.txt)
     * @throws IOException
     */
    public  void create(String path) throws IOException{
        //创建文件
        if(filesystem.exists(new Path(path)))
        {
            System.out.println("文件已存在");
        }
        else
        {
            FSDataOutputStream outputStream=  filesystem.create(new Path(path));
            System.out.println("文件创建成功");
        }
    }

    /**
     * 查看文件内容
     * @param dst hdfs文件地址（例:/hadoop/abc.txt）
     * @throws IOException
     */
    public void read(String dst) throws IOException {
        if(filesystem.exists(new Path(dst)))
        {
            FSDataInputStream inputstream=filesystem.open(new Path(dst));
            InputStreamReader isr=new InputStreamReader(inputstream);
            BufferedReader br=new BufferedReader(isr);
            String str=br.readLine();
            while(str!=null){
                System.out.println(str);
                str=br.readLine();
            }
            br.close();
            isr.close();
            inputstream.close();
        }
       else
        {
            System.out.println("文件不存在");
        }
    }

    /**
     * 将dst1重命名为dst2，也可以进行文件的移动
     * @param oldpath 旧名
     * @param newpath 新名
     */
    public void moveFile(String oldpath, String newpath) {
        Path path1 = new Path(oldpath);
        Path path2 = new Path(newpath);
        try {
            if (!filesystem.exists(path1)) {
                System.out.println(oldpath + " 文件不存在！");
                return;
            }
            if (filesystem.exists(path2)) {
                System.out.println(newpath + "已存在！");
                return;
            }
            // 将文件进行重命名，可以起到移动文件的作用
            filesystem.rename(path1, path2);
            System.out.println("文件已重命名！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 上传文件到hdfs
     * @param local
     * @param dst
     */
    public void putFile(String local, String dst) {
        try {
            // 从本地将文件拷贝到HDFS中，如果目标文件已存在则进行覆盖
            filesystem.copyFromLocalFile(new Path(local), new Path(dst));
            System.out.println("上传成功！");
            // 关闭连接
        } catch (IOException e) {
            System.out.println("上传失败！");
            e.printStackTrace();
        }
    }

    public void putfilebar() throws Exception {
        //上传文件的输入流
        InputStream inputStream=new BufferedInputStream(new FileInputStream("G://text.txt"));

        FSDataOutputStream fs=filesystem.create(new Path("/idea/"), new Progressable() {
            @Override
            public void progress() {
                System.out.println("X");
            }
        });
        IOUtils.copyBytes(inputStream,fs,4096);
    }

    /**
     * 下载文件到本地
     * @param dst
     * @param local
     */
    public void getFile(String dst, String local) {
        try {
            if (!filesystem.exists(new Path(dst))) {
                System.out.println("文件不存在！");
            } else {
                filesystem.copyToLocalFile(new Path(dst), new Path(local));
                System.out.println("下载成功！");
            }
        } catch (IOException e) {
            System.out.println("下载失败！");
            e.printStackTrace();
        }
    }


    /**
     * 显示目录下所有文件
     * @param dst
     */
    public void listStatus(String dst) {
        try {
            if (!filesystem.exists(new Path(dst))) {
                System.out.println("目录不存在！");
                return;
            }
            // 得到文件的状态
            FileStatus[] status = filesystem.listStatus(new Path(dst));
            for (FileStatus s : status) {
                System.out.println(s.getPath().getName());
            }

        } catch (IllegalArgumentException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 删除hdfs中的文件
     * @param dst
     */
    public void deleteFile(String dst) {
        try {
            if (!filesystem.exists(new Path(dst))) {
                System.out.println("文件不存在！");
            } else {
                filesystem.delete(new Path(dst), true);
                System.out.println("删除成功！");
            }
        } catch (IOException e) {
            System.out.println("删除失败！");
            e.printStackTrace();
        }
    }


    /**
     * 关闭filesyatem
     */
    @After
    public void destory()
    {
        try {
            filesystem.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

