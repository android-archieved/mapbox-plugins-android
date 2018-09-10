package com.mapbox.mapboxsdk.plugins.annotation;

import android.support.test.runner.AndroidJUnit4;
import com.mapbox.mapboxsdk.plugins.testapp.activity.BuildingActivity;
import org.junit.Test;
import org.junit.runner.RunWith;
import timber.log.Timber;

import static com.mapbox.mapboxsdk.plugins.annotation.MapboxMapAction.invoke;
import static com.mapbox.mapboxsdk.style.layers.Property.LINE_CAP_BUTT;
import static com.mapbox.mapboxsdk.style.layers.Property.LINE_TRANSLATE_ANCHOR_MAP;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Basic smoke tests for LineManager
 */
@RunWith(AndroidJUnit4.class)
public class LineManagerTest extends BaseActivityTest {

  private LineManager lineManager;

  @Override
  protected Class getActivityClass() {
    return BuildingActivity.class;
  }

  private void setupLineManager() {
    Timber.i("Retrieving layer");
    invoke(mapboxMap, (uiController, mapboxMap) -> {
      lineManager = new LineManager(mapboxMap);
    });
  }

  @Test
  public void testLineCapAsConstant() {
    validateTestSetup();
    setupLineManager();
    Timber.i("line-cap");
    invoke(mapboxMap, (uiController, mapboxMap) -> {
      assertNotNull(lineManager);

      lineManager.setLineCap(LINE_CAP_BUTT);
      assertEquals((String) lineManager.getLineCap(), (String) LINE_CAP_BUTT);
    });
  }

  @Test
  public void testLineMiterLimitAsConstant() {
    validateTestSetup();
    setupLineManager();
    Timber.i("line-miter-limit");
    invoke(mapboxMap, (uiController, mapboxMap) -> {
      assertNotNull(lineManager);

      lineManager.setLineMiterLimit(0.3f);
      assertEquals((Float) lineManager.getLineMiterLimit(), (Float) 0.3f);
    });
  }

  @Test
  public void testLineRoundLimitAsConstant() {
    validateTestSetup();
    setupLineManager();
    Timber.i("line-round-limit");
    invoke(mapboxMap, (uiController, mapboxMap) -> {
      assertNotNull(lineManager);

      lineManager.setLineRoundLimit(0.3f);
      assertEquals((Float) lineManager.getLineRoundLimit(), (Float) 0.3f);
    });
  }

  @Test
  public void testLineTranslateAsConstant() {
    validateTestSetup();
    setupLineManager();
    Timber.i("line-translate");
    invoke(mapboxMap, (uiController, mapboxMap) -> {
      assertNotNull(lineManager);

      lineManager.setLineTranslate(new Float[] {0f, 0f});
      assertEquals((Float[]) lineManager.getLineTranslate(), (Float[]) new Float[] {0f, 0f});
    });
  }

  @Test
  public void testLineTranslateAnchorAsConstant() {
    validateTestSetup();
    setupLineManager();
    Timber.i("line-translate-anchor");
    invoke(mapboxMap, (uiController, mapboxMap) -> {
      assertNotNull(lineManager);

      lineManager.setLineTranslateAnchor(LINE_TRANSLATE_ANCHOR_MAP);
      assertEquals((String) lineManager.getLineTranslateAnchor(), (String) LINE_TRANSLATE_ANCHOR_MAP);
    });
  }

  @Test
  public void testLineDasharrayAsConstant() {
    validateTestSetup();
    setupLineManager();
    Timber.i("line-dasharray");
    invoke(mapboxMap, (uiController, mapboxMap) -> {
      assertNotNull(lineManager);

      lineManager.setLineDasharray(new Float[] {});
      assertEquals((Float[]) lineManager.getLineDasharray(), (Float[]) new Float[] {});
    });
  }
}
