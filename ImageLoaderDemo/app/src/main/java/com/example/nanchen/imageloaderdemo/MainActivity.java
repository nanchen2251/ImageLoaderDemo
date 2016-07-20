package com.example.nanchen.imageloaderdemo;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

public class MainActivity extends AppCompatActivity {

    private String imageUrl = "http://pic.cnblogs.com/face/845964/20160301162812.png";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = (ImageView) findViewById(R.id.main_image);

        //图片展示的管理操作
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .displayer(new RoundedBitmapDisplayer(20))
                .showImageOnFail(R.mipmap.ic_launcher)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .build();


        //这样自定义设置后就可以管理二级缓存和三级缓存了
        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(this)
                .memoryCacheSizePercentage(20)//设置占用内存的百分比
                .diskCacheFileCount(100)//设置最大下载图片数
                .diskCacheSize(5 * 1024 * 1024)
                .defaultDisplayImageOptions(options)
                .build();

//        String imagePath = "/mnt/sdcard/image.png";
//        String imageUrl = ImageDownloader.Scheme.FILE.wrap(imagePath);

//        listView.setOnScrollListener(new PauseOnScrollListener(imageLoader, pauseOnScroll, pauseOnFling));
//        gridView.setOnScrollListener(new PauseOnScrollListener(imageLoader, pauseOnScroll, pauseOnFling));


        ImageLoader.getInstance().init(configuration);//初始化完成
        ImageLoader.getInstance().displayImage(imageUrl,imageView);

    }
}
