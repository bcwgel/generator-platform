package cn.stylefeng.guns.generator.modular.restful.feign;

import cn.stylefeng.guns.generator.core.generator.AbstractCustomGenerator;
import org.beetl.core.Template;

import java.io.File;
import java.util.Map;

/**
 * feign的provider生成器
 *
 * @author fengshuonan
 * @date 2018-12-13-2:20 PM
 */
public class FeignProviderGenerator extends AbstractCustomGenerator {

    public FeignProviderGenerator(Map<String, Object> tableContext) {
        super(tableContext);
    }

    @Override
    public void bindingOthers(Template template) {
        template.binding("apiPackage", contextParam.getProPackage() + ".api");
        template.binding("providerPackage", contextParam.getProPackage() + ".provider");
    }

    @Override
    public String getTemplateResourcePath() {
        return "/feignTemplates/FeignProvider.btl";
    }

    @Override
    public String getGenerateFilePath() {
        String proPackage = this.contextParam.getProPackage();
        String proPath = proPackage.replaceAll("\\.", "/");
        File file = new File(contextParam.getOutputPath() + "/" + proPath + "/provider/" + tableContext.get("entity") + "Provider.java");
        return file.getAbsolutePath();
    }
}
