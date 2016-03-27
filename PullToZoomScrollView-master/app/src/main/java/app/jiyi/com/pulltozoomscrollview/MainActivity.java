package app.jiyi.com.pulltozoomscrollview;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 主函数里无须写任何代码
 */
public class MainActivity extends Activity implements PullToZoomScrollView.OnScrollListener{

    LinearLayout linearLayout1,linearLayout2;
    FrameLayout frameLayout;
    TextView textView;
    int height=0;
    PullToZoomScrollView scrollView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayout1= (LinearLayout) findViewById(R.id.linear1);
        linearLayout2= (LinearLayout) findViewById(R.id.linear2);
        frameLayout= (FrameLayout) findViewById(R.id.framelayout);
        textView= (TextView) findViewById(R.id.txt1);
        scrollView= (PullToZoomScrollView) findViewById(R.id.scrollView);
        scrollView.setOnScrollListener(this);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if(hasFocus){
            height= frameLayout.getHeight();
        }
    }

    @Override
    public void onScroll(int lastY) {

        if(lastY>=height){
            if(textView.getParent()!=linearLayout2){
                linearLayout1.removeView(textView);
                linearLayout2.addView(textView);
            }
        }else{
            if(textView.getParent()!=linearLayout1){
                linearLayout2.removeView(textView);
                linearLayout1.addView(textView);
            }

        }
    }
}
