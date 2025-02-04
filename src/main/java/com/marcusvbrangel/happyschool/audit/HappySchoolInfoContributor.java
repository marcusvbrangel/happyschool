package com.marcusvbrangel.happyschool.audit;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class HappySchoolInfoContributor implements InfoContributor {

    @Override
    public void contribute(Info.Builder builder) {
        Map<String, String> infoMap = new HashMap<String, String>();
        infoMap.put("App Name", "HappySchool");
        infoMap.put("App Description", "Happy Scholl for Students happy");
        infoMap.put("App Version", "1.0.0");
        infoMap.put("Contact Email", "info@happyschool.com");
        infoMap.put("Contact Mobile", "+1(45)78451257");
        builder.withDetail("happyschool-info", infoMap);
    }

}
