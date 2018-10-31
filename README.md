[![](https://jitpack.io/v/dalejuls/Common-Kotlin-Extensions-Android.svg)](https://jitpack.io/#dalejuls/Common-Kotlin-Extensions-Android)


# Common-Kotlin-Extensions-Android
Android library for common Kotlin utilities and extensions

**Installation:**

Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  

Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.dalejuls:Common-Kotlin-Extensions-Android:1.0.01'
	}



Modules:

• `ContextUtils` - contains helper methods for global tasks like `showToast(...)`, `View.fadeIn()`

• `ViewUtils` - contains helper methods for anything that extends `View`
