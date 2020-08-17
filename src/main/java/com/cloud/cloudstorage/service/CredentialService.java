package com.cloud.cloudstorage.service;

import com.cloud.cloudstorage.mapper.CredentialMapper;
import com.cloud.cloudstorage.model.Credential;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CredentialService {
    private CredentialMapper mMapper;

    public CredentialService(CredentialMapper credentialMapper) {
        mMapper = credentialMapper;
    }

    public List<Credential> getCredentials(Integer userId) {
        return mMapper.getCredentials(userId);
    }

    public int insertCredential(Credential credential) {
        return mMapper.insert(credential);
    }

    public int updateCredential(Credential credential) {
        return mMapper.update(credential);
    }

    public int deleteCredential(int id) {
        return mMapper.delete(id);
    }
}
