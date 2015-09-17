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
 * 覆盖之前的生成的文件！
 * @author Administrator
 *
 */
public class Generator1 {
	
	public void generatorOneFile(final String fileName,final String dir) throws Exception {
		
		File[] files = new File(dir).listFiles(new FileFilter() {
			public boolean accept(File file) {
				//读取mybator-*.xml的文件
				return file.isFile() && file.getName().equalsIgnoreCase("mybator-" + fileName + ".xml");
			}
		});
		
		if (files == null) {
			return;
		}
		
		for (File file : files) {
			System.out.println(file.getName() + "开始处理");
			List<String> warnings = new ArrayList<String>();
			boolean overwrite = true;
			ConfigurationParser cp = new ConfigurationParser(warnings);
			Configuration config = cp.parseConfiguration(file);
			DefaultShellCallback callback = new DefaultShellCallback(overwrite);
			MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
			myBatisGenerator.generate(null);
			System.out.println(file.getName() + "处理完成");
		}
		
	}
	public static void main(String[] args) {
		Generator1 generator1 = new Generator1();
		try {
			//这个路径，需要改一改。
			generator1.generatorOneFile("t_user", "D:\\git\\mybatis_test\\testmybatis2\\dev");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
