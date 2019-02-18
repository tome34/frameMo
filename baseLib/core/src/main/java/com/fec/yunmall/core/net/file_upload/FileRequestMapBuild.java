package com.fec.yunmall.core.net.file_upload;

import java.io.File;
import okhttp3.MultipartBody;

/**
 * Created by XQ Yang on 2017/9/6  16:46.
 * Description : 文件上传参数
 */

public interface FileRequestMapBuild extends RequestMapBuild<MultipartBody> {
    FileRequestMapBuild put(String key,File file);
    FileRequestMapBuild addAllProgressCallBack(ProgressResponseCallBack callBack);
}
