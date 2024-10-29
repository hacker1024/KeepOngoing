# KeepOngoing

In Android 14, [users are able to dismiss notifications that apps have set as "ongoing"](https://developer.android.com/about/versions/14/behavior-changes-all#non-dismissable-notifications).
This _feature_ is not appreciated by everyone, though.

_KeepOngoing_ is an Xposed module that aims to restore the old non-dismissable
notification behaviour found in Android 13 and earlier.

## Compatibility

### Android

TL;DR: _KeepOngoing_ requires `android-14.0.0_r15` or older.

On a Pixel, this equates to
a security patch level of November 2023. Other OEMs are not so quick to update their
Android revisions, though: My Motorola Edge 30 Pro with the August 2024 security patch
is still based on a compatible version.

If you are unsure, you can try this module without concern; it is designed to fail gracefully.

The reason for this limitation is that Google kept the old behaviour behind a flag when
they [first introduced the change](https://android.googlesource.com/platform/frameworks/base/+/6afb4824218b721f190e250b3c343380d2637ff6)
that was only [removed five months later](https://android.googlesource.com/platform/frameworks/base/+/9f63d6746f1f124a1a7da2e67a8a359d72401d7b).
This module simply disables that flag.

It is certainly possible to restore the older behaviour on newer revisions of Android,
but doing so would require reimplementing the removed logic in this module. As my
current device does not require this, I do not have the motivation to implement it.
PRs are welcome.

### Xposed

This module has been tested with [LSposed_mod](https://github.com/mywalkb/LSPosed_mod).

## Installation

1. Install the app
2. Enable the Xposed module
3. Restart SystemUI (or reboot if your Xposed implementation requires it)