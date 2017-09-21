#!/usr/bin/env bash
echo y | android update sdk --no-ui --all --filter "tools,build-tools-26,platform-tools"
echo y | android update sdk --no-ui --all --filter "android-26"
echo y | android update sdk --no-ui --all --filter "build-tools-26.0.1"
echo y | android update sdk --no-ui --all --filter "platform-tools-preview"
echo y | android update sdk --no-ui --all --filter "build-tools-26,extra-google-m2repository,extra-android-support,extra-android-m2repository"