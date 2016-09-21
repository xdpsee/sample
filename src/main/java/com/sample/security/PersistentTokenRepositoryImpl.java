package com.sample.security;

import com.sample.data.mapper.RememberMapper;
import com.sample.data.po.Remember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import java.util.Date;

/**
 * Remember-Me
 * @author zhenhui on 16/9/16.
 */
public class PersistentTokenRepositoryImpl implements PersistentTokenRepository {

    @Autowired
    private RememberMapper rememberMapper;

    @Override
    public void createNewToken(PersistentRememberMeToken token) {
        Remember remember = new Remember(token);
        rememberMapper.insert(remember);
    }

    @Override
    public void updateToken(String series, String tokenValue, Date lastUsed) {
        rememberMapper.update(series, tokenValue, lastUsed);
    }

    @Override
    public PersistentRememberMeToken getTokenForSeries(String seriesId) {
        Remember remember = rememberMapper.selectBySeries(seriesId);
        if (remember != null) {
            return new PersistentRememberMeToken(
                    remember.getUsername(),
                    remember.getSeries(),
                    remember.getToken(),
                    remember.getTimestamp()
            );
        }

        return null;
    }

    @Override
    public void removeUserTokens(String username) {
        rememberMapper.removeByUsername(username);
    }
}
