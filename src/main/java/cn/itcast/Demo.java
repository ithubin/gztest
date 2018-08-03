package cn.itcast;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.junit.Test;

import java.io.File;

/**
 * Created by on 2018/7/28.
 */
public class Demo {

    @Test
    public void addIndex() {
        try {
            //指定
            String path = "C:\\lessons\\indexs";
            //创建目录对象，关联索引库存储位置

            Directory d = FSDirectory.open(new File(path));

            //创建分词器
            Analyzer analyzer = new StandardAnalyzer();

            //创建核心配置文件
            IndexWriterConfig iwc = new IndexWriterConfig(Version.LUCENE_4_10_3,analyzer);


            //创建索引库核心对象
            IndexWriter indexWriter = new IndexWriter(d, iwc);

            //创建文档对象
            Document doc = new Document();

            doc.add(new StringField("id","u101010", Field.Store.NO));

            indexWriter.addDocument(doc);

            indexWriter.commit();


        } catch (Exception e) {

            e.printStackTrace();
        }


    }
}
