package org.sertech.maroma.audit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.domain.AuditorAware;

/**
 * Created by German on 24/07/2016.
 */
public class AuditorAwareBean implements AuditorAware<String> {

    private static final Log log = LogFactory.getLog(AuditorAwareBean.class);
    private String currentAuditor = "admin";

    public String getCurrentAuditor() {
        String currentUser = this.currentAuditor;
        /*try {
            currentUser = SecurityContextHolder.getContext()
                    .getAuthentication().getName();
        } catch (Exception e) {
            log.info("There is no user in the securityContext, using default value 'admin'");
        }*/
        return currentUser;
    }

    public void setCurrentAuditor(String auditor) {
        this.currentAuditor = auditor;
    }

    @Override
    public String toString() {
        return "AuditorAwareBean [currentAuditor=" + currentAuditor + "]";
    }
}
