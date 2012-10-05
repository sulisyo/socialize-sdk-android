package com.socialize.test.ui.actionbar;

import java.util.concurrent.CountDownLatch;
import android.app.Activity;
import android.content.Intent;
import com.socialize.Socialize;
import com.socialize.SocializeAccess;
import com.socialize.api.action.entity.SocializeEntityUtils;
import com.socialize.api.action.like.SocializeLikeUtils;
import com.socialize.entity.Entity;
import com.socialize.listener.entity.EntityGetListener;
import com.socialize.listener.like.LikeGetListener;
import com.socialize.sample.ui.ActionBarAutoActivity2;
import com.socialize.test.SocializeManagedActivityTest;
import com.socialize.test.ui.util.TestUtils;

public abstract class ActionBarTest extends SocializeManagedActivityTest<ActionBarAutoActivity2> {

	Entity entity = Entity.newInstance("http://entity1.com" + Math.random(), "no name");
	
	CountDownLatch globalLatch = null;
	
	final SocializeLikeUtils mockLikeUtils = new SocializeLikeUtils() {
		@Override
		public void getLike(Activity context, String entityKey, LikeGetListener listener) {
			listener.onGet(null); // not liked
		}
	};
	
	final SocializeEntityUtils mockEntityUtils = new SocializeEntityUtils() {
		@Override
		public void getEntity(Activity context, String key, final EntityGetListener listener) {
			listener.onGet(entity);
			globalLatch.countDown();
		}
	};
	
	
	public ActionBarTest() {
		super("com.socialize.sample.ui", ActionBarAutoActivity2.class);
	}
	
	@Override
	protected void setUp() throws Exception {
		
		super.setUp();
		
		Intent intent = new Intent();
		intent.putExtra(Socialize.ENTITY_OBJECT, entity);
		intent.putExtra("manual", isManual());
		setActivityIntent(intent);
		
		globalLatch = new CountDownLatch(1);
		
		SocializeAccess.setLikeUtilsProxy(mockLikeUtils);
		SocializeAccess.setEntityUtilsProxy(mockEntityUtils);		
		
		TestUtils.setUp(this);

	}
	
	@Override
	protected void tearDown() throws Exception {
		TestUtils.tearDown(this);
		super.tearDown();
	}
	
	public abstract boolean isManual();
	
}
