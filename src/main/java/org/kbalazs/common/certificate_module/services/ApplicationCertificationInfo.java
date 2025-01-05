package org.kbalazs.common.certificate_module.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.cert.X509Certificate;
import java.util.Enumeration;

@Service
@Log4j2
@RequiredArgsConstructor
public class ApplicationCertificationInfo
{
    private final ResourceLoader resourceLoader;

    public void log(String keyStoreType, String password, String keyStoreClassPath)
    {
        try
        {
            KeyStore keyStore = KeyStore.getInstance(keyStoreType);
            try (FileInputStream fis = new FileInputStream(resourceLoader.getResource(keyStoreClassPath).getFile()))
            {
                keyStore.load(fis, password.toCharArray());
            }

            Enumeration<String> aliases = keyStore.aliases();
            if (aliases.hasMoreElements())
            {
                String alias = aliases.nextElement();

                X509Certificate certificate = (X509Certificate) keyStore.getCertificate(alias);
                if (certificate != null)
                {
                    log.info(
                        "Certificate => Subject: {} | Issuer: {} | Valid From: {} | Valid Until: {}",
                        certificate.getSubjectX500Principal(),
                        certificate.getIssuerX500Principal(),
                        certificate.getNotBefore(),
                        certificate.getNotAfter()
                    );

                    return;
                }

                log.error("No certificate found for alias: {}", alias);

                return;
            }

            log.error("No aliases found in the keystore.");
        }
        catch (Exception e)
        {
            log.error("Error while processing certificate", e);
        }
    }
}
