<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

	<div id="blogGrid" class="col-xs-w100">
	</div>
	<div id="blogView" class="viewContainer col-xs-w100" style="display:none;">
		<div class="col-xs-w100">
			<div class="col-xs-w100">
				<a id="blogTextBoxAddBtn" type="button" class="btn btn-sm btn-info pull-left" >글상자</a>
				<a id="blogImgAddBtn" type="button" class="btn btn-sm btn-info pull-left" >이미지</a>
				<a id="blogCodeAddBtn" type="button" class="btn btn-sm btn-info pull-left" >미정</a>
				
			
				<a id="blogSaveBtn" type="button" class="btn btn-sm btn-info pull-right" >저장하기</a>
				<a id="blogCancelBtn" type="button" class="btn btn-sm btn-info pull-right" >메인으로</a>
			</div>
		
		
			<div class="col-xs-w100" style="margin-bottom:20px;">
				<div class="col-xs-w20">
					<select id="blogTitle" class="col-xs-w100">
					</select>
				</div>
				<div class="col-xs-w80">
					<input id="blogSubject" type="text" class="col-xs-w100"/>
				</div>
			</div>
			
			
			<div id="blogViewArea" class="col-xs-w100">
			
			</div>
		</div>
	
	</div>

	<script src="/js/views/manage/blog.js"></script>