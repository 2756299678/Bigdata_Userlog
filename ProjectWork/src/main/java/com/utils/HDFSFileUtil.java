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
     * junit���Ժ���
     * @throws IOException
     */
    @Test
    public void Text() throws Exception {
        //����Ŀ¼
        //mkdir("/idea/");

        //�����ļ�
        //create("/idea/haha.txt");

        //�鿴hdfs�ļ�����
        //read("/idea/text.txt");

        //�ļ�������
        //moveFile("/idea/haha.txt","/idea/hello.txt");

        //�ϴ��ļ�
       // putFile("G://text.txt","/idea/");

        //�����ļ�
        //getFile("/idea/abc.txt","G://");

        //��ѯĿ¼�µ������ļ�
        //listStatus("/idea/");

        //ɾ���ļ�
        //deleteFile("/idea/hello.txt");

        //putfilebar();
    }
    
    /**
     * ����Ŀ¼
     * @param path ����Ŀ¼�ĵ�ַ������/hadoop/��
     * @throws IOException
     */
    public boolean ifExit(String path) throws Exception {
        //����hdfsĿ¼
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
     * ����Ŀ¼
     * @param path ����Ŀ¼�ĵ�ַ������/hadoop/��
     * @throws IOException
     */
    public void mkdir(String path) throws IOException {
        //����hdfsĿ¼
        if(filesystem.exists(new Path(path)))
        {
            System.out.println("Ŀ¼�Ѵ���");
        }
        else
        {
            boolean result=filesystem.mkdirs(new Path(path));
            System.out.println(result);
        }
    }

    /**
     * �����ļ�
     * @param path hdfs�ļ���ַ(����/hadoop/abc.txt)
     * @throws IOException
     */
    public  void create(String path) throws IOException{
        //�����ļ�
        if(filesystem.exists(new Path(path)))
        {
            System.out.println("�ļ��Ѵ���");
        }
        else
        {
            FSDataOutputStream outputStream=  filesystem.create(new Path(path));
            System.out.println("�ļ������ɹ�");
        }
    }

    /**
     * �鿴�ļ�����
     * @param dst hdfs�ļ���ַ����:/hadoop/abc.txt��
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
            System.out.println("�ļ�������");
        }
    }

    /**
     * ��dst1������Ϊdst2��Ҳ���Խ����ļ����ƶ�
     * @param oldpath ����
     * @param newpath ����
     */
    public void moveFile(String oldpath, String newpath) {
        Path path1 = new Path(oldpath);
        Path path2 = new Path(newpath);
        try {
            if (!filesystem.exists(path1)) {
                System.out.println(oldpath + " �ļ������ڣ�");
                return;
            }
            if (filesystem.exists(path2)) {
                System.out.println(newpath + "�Ѵ��ڣ�");
                return;
            }
            // ���ļ��������������������ƶ��ļ�������
            filesystem.rename(path1, path2);
            System.out.println("�ļ�����������");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * �ϴ��ļ���hdfs
     * @param local
     * @param dst
     */
    public void putFile(String local, String dst) {
        try {
            // �ӱ��ؽ��ļ�������HDFS�У����Ŀ���ļ��Ѵ�������и���
            filesystem.copyFromLocalFile(new Path(local), new Path(dst));
            System.out.println("�ϴ��ɹ���");
            // �ر�����
        } catch (IOException e) {
            System.out.println("�ϴ�ʧ�ܣ�");
            e.printStackTrace();
        }
    }

    public void putfilebar() throws Exception {
        //�ϴ��ļ���������
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
     * �����ļ�������
     * @param dst
     * @param local
     */
    public void getFile(String dst, String local) {
        try {
            if (!filesystem.exists(new Path(dst))) {
                System.out.println("�ļ������ڣ�");
            } else {
                filesystem.copyToLocalFile(new Path(dst), new Path(local));
                System.out.println("���سɹ���");
            }
        } catch (IOException e) {
            System.out.println("����ʧ�ܣ�");
            e.printStackTrace();
        }
    }


    /**
     * ��ʾĿ¼�������ļ�
     * @param dst
     */
    public void listStatus(String dst) {
        try {
            if (!filesystem.exists(new Path(dst))) {
                System.out.println("Ŀ¼�����ڣ�");
                return;
            }
            // �õ��ļ���״̬
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
     * ɾ��hdfs�е��ļ�
     * @param dst
     */
    public void deleteFile(String dst) {
        try {
            if (!filesystem.exists(new Path(dst))) {
                System.out.println("�ļ������ڣ�");
            } else {
                filesystem.delete(new Path(dst), true);
                System.out.println("ɾ���ɹ���");
            }
        } catch (IOException e) {
            System.out.println("ɾ��ʧ�ܣ�");
            e.printStackTrace();
        }
    }


    /**
     * �ر�filesyatem
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

