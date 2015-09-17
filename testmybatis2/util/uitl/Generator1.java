package uitl;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
/**
 * ����֮ǰ�����ɵ��ļ���
 * @author Administrator
 *
 */
public class Generator1 {
	
	public void generatorOneFile(final String fileName,final String dir) throws Exception {
		
		File[] files = new File(dir).listFiles(new FileFilter() {
			public boolean accept(File file) {
				//��ȡmybator-*.xml���ļ�
				return file.isFile() && file.getName().equalsIgnoreCase("mybator-" + fileName + ".xml");
			}
		});
		
		if (files == null) {
			return;
		}
		
		for (File file : files) {
			System.out.println(file.getName() + "��ʼ����");
			List<String> warnings = new ArrayList<String>();
			boolean overwrite = true;
			ConfigurationParser cp = new ConfigurationParser(warnings);
			Configuration config = cp.parseConfiguration(file);
			DefaultShellCallback callback = new DefaultShellCallback(overwrite);
			MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
			myBatisGenerator.generate(null);
			System.out.println(file.getName() + "�������");
		}
		
	}
	public static void main(String[] args) {
		Generator1 generator1 = new Generator1();
		try {
			//���·������Ҫ��һ�ġ�
			generator1.generatorOneFile("t_user", "D:\\git\\mybatis_test\\testmybatis2\\dev");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
