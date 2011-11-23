/*
 * Copyright (c) 2011 Socialize Inc.
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.socialize.sample.mocks;

import com.socialize.api.SocializeSession;
import com.socialize.auth.AuthProvider;
import com.socialize.auth.AuthProviderType;
import com.socialize.entity.User;

/**
 * @author Jason Polites
 *
 */
public class MockSocializeSession implements SocializeSession {

	User user;
	String key = "all";
	String sec = "my";
	String tok = "base";
	String toksec = "belongs";
	String host = "to";
	
	public MockSocializeSession() {
		super();
		user = new User();
		user.setId(-1L);
	}

	/* (non-Javadoc)
	 * @see com.socialize.api.SocializeSession#getUser()
	 */
	@Override
	public User getUser() {
		return user;
	}

	/* (non-Javadoc)
	 * @see com.socialize.api.SocializeSession#getConsumerKey()
	 */
	@Override
	public String getConsumerKey() {
		return key;
	}

	/* (non-Javadoc)
	 * @see com.socialize.api.SocializeSession#getConsumerSecret()
	 */
	@Override
	public String getConsumerSecret() {
		return sec;
	}

	/* (non-Javadoc)
	 * @see com.socialize.api.SocializeSession#getConsumerToken()
	 */
	@Override
	public String getConsumerToken() {
		return tok;
	}

	/* (non-Javadoc)
	 * @see com.socialize.api.SocializeSession#getConsumerTokenSecret()
	 */
	@Override
	public String getConsumerTokenSecret() {
		return toksec;
	}

	/* (non-Javadoc)
	 * @see com.socialize.api.SocializeSession#getHost()
	 */
	@Override
	public String getHost() {
		return host;
	}

	/* (non-Javadoc)
	 * @see com.socialize.api.SocializeSession#get3rdPartyUserId()
	 */
	@Override
	public String get3rdPartyUserId() {
		return null;
	}

	/* (non-Javadoc)
	 * @see com.socialize.api.SocializeSession#get3rdPartyToken()
	 */
	@Override
	public String get3rdPartyToken() {
		return null;
	}

	/* (non-Javadoc)
	 * @see com.socialize.api.SocializeSession#get3rdPartyAppId()
	 */
	@Override
	public String get3rdPartyAppId() {
		return null;
	}

	/* (non-Javadoc)
	 * @see com.socialize.api.SocializeSession#getAuthProviderType()
	 */
	@Override
	public AuthProviderType getAuthProviderType() {
		return AuthProviderType.SOCIALIZE;
	}

	/* (non-Javadoc)
	 * @see com.socialize.api.SocializeSession#getAuthProvider()
	 */
	@Override
	public AuthProvider getAuthProvider() {
		return null;
	}

	/* (non-Javadoc)
	 * @see com.socialize.api.SocializeSession#clear(com.socialize.auth.AuthProviderType)
	 */
	@Override
	public void clear(AuthProviderType type) {}

}
