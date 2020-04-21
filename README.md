# CImage

***
How to get a this Git project into your build:
===
###Add it in your root build.gradle at the end of repositories:

`allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}`
  
  _Notes:_ not add in buildscript.
  
  ###Add the dependency:
  
 ` dependencies {
	        implementation 'com.github.nans1996:CImage:1.01'
	}`
  ***
  Using the methods
  ====
  ###Set dimensions of image
  
` ControllClass.BitmapSize(Bitmap bitmap, int heigth, int width)`
  
  Retun new bitmap.
  
  ###Check extension of image
  
  `ControllClass.CheckMimetype(String mimetype, String type)`
  
  mimetype - current image expansion, type - for which you need to check.
  
  The method defines three types of extensions: jpeg, png or gif. Return true or false.
