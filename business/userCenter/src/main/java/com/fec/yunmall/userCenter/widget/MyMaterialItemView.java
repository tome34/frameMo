package com.fec.yunmall.userCenter.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.fec.yunmall.userCenter.R;

/**
 * @author tome
 * @date 2019/2/14  16:25
 * @describe ${自定义组合view}
 */
public class MyMaterialItemView extends RelativeLayout{
    public MyMaterialItemView(Context context) {
        this(context, null);
    }

    public MyMaterialItemView(Context context,AttributeSet attrs) {
        this(context,attrs, 0);
    }

    /**
     *  用在xml文件中使用View的时候
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public MyMaterialItemView(Context context,AttributeSet attrs,int defStyleAttr) {
        super(context,attrs,defStyleAttr);
        // 加载一个布局,挂载视图
      //  View.inflate(context, R.layout.user_item_material_view, this);
        LayoutInflater.from(context).inflate(R.layout.user_item_material_view, this);

        TypedArray ta = context.obtainStyledAttributes(attrs,R.styleable.AttrsEmptyView);
        //设置标题文本
        CharSequence title = ta.getText(R.styleable.user_MyMaterialItem_user_materialTitle);
        TextView tvTitle = (TextView)findViewById(R.id.tv_mymaterial_title);
        tvTitle.setText(title);
        //设置内容文本
        CharSequence content = ta.getText(R.styleable.user_MyMaterialItem_user_materialContent);
        TextView tvContent = (TextView)findViewById(R.id.tv_my_material_content);
        tvContent.setText(content);
        //设置图标是否显示
        boolean aBoolean = ta.getBoolean(R.styleable.user_MyMaterialItem_user_materialToggle, false);
        ImageView imageView = (ImageView)findViewById(R.id.iv_mymaterial);
        imageView.setVisibility(aBoolean? View.VISIBLE : View.GONE);
        //释放资源
        ta.recycle();
    }
}
