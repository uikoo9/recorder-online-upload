# recorder-online-upload

## 简介
1. 在线录音并直接上传到服务器
2. 封装了[FlashWavRecorder](https://github.com/cykod/FlashWavRecorder)

## 使用
1. 运行
	1. 请下载本项目，并导入myeclipse中
	2. 跑起项目，访问http://localhost:8080/recorder-online-upload查看效果
2. 定制
	1. 打开WEB-INF/view/index.html
	2. 只有以下代码是需要的：

	<script type="text/javascript" src="${base}/WUI/qrecord/js/swfobject.js"></script>
	<script type="text/javascript" src="${base}/WUI/qrecord/js/recorder.js"></script>
	<script type="text/javascript" src="${base}/WUI/qrecord/js/main.js"></script>
	<link rel="stylesheet" href="${base}/WUI/qrecord/style.css">
	<div class="qcontainer" id="myRecordDiv">
		<div id="recorder-audio" class="control_panel idle">
			<button class="record_button" onclick="FWRecorder.record('audio', 'audio.wav');" title="Record">
				<img src="${base}/WUI/qrecord/images/record.png" alt="开始录音">
			</button>
			<button class="stop_recording_button" onclick="FWRecorder.stopRecording('audio');" title="Stop Recording">
				<img src="${base}/WUI/qrecord/images/stop.png" alt="停止录音">
			</button>
			<button class="play_button" onclick="FWRecorder.playBack('audio');" title="Play">
				<img src="${base}/WUI/qrecord/images/play.png" alt="播放">
			</button>
			<button class="pause_playing_button" onclick="FWRecorder.pausePlayBack('audio');" title="Pause Playing">
				<img src="${base}/WUI/qrecord/images/pause.png" alt="暂停">
			</button>
			<button class="stop_playing_button" onclick="FWRecorder.stopPlayBack();" title="Stop Playing">
				<img src="${base}/WUI/qrecord/images/stop.png" alt="停止">
			</button>
			<div class="level"></div>
		</div>
	
		<div class="details">
			<button class="show_level" onclick="FWRecorder.observeLevel();">显示声波</button>
			<button class="hide_level" onclick="FWRecorder.stopObservingLevel();" style="display: none;">隐藏声波</button>
			<button class="show_settings" onclick="microphonePermission()">麦克风权限</button>
			<span id="save_button" style="display:inline-block;"> 
				<object data="${base}/WUI/qrecord//recorder.swf" name="recorderApp" id="recorderApp" type="application/x-shockwave-flash" height="24" width="24"><param value="upload_image=${base}/WUI/qrecord/images/upload.png" name="flashvars"></object> 
			</span>
			<div id="status">最后的录音事件：ready</div>
			<div>录音时长：<span id="duration"></span></div>
			<div>上传状态：<span id="upload_status"></span></div>
			<input value="" id="qrecordId" type="hidden">
		</div>
	
		<!-- 这个form的action写上传路径 -->
		<form id="uploadForm" name="uploadForm" action="${base}/upload">
			<input name="authenticity_token" value="xxxxx" type="hidden">
			<input name="upload_file[parent_id]" value="1" type="hidden">
			<input name="format" value="json" type="hidden">
		</form>
	</div>

	3. 将上面代码中的${base}替换成自己项目的路径
	4. 将上面代码中form的action替换成自己的上传文件处理action
	5. 将main.js中一些base路径替换为自己对应的路径
## 详细说明
详细说明请访问这里[]()

## 作者
1. uikoo9
2. 欢迎访问[uikoo9.com](http://uikoo9.com)
