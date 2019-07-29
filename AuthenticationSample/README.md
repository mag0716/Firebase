# Firebase Authentication

* https://firebase.google.com/docs/auth

## 概要

ユーザ認証のための BaaS
iOS, Android, Webアプリケーションにおいてユーザ認証を実装するためのクライアントSDKとバックエンドサービスを提供する
OAuth 2.0 や OpenID Connect などの業界標準を使用している

## できること

### FirebaseUI Auth

認証のための汎用的な UI とユーザ認証機能を提供する
エッジケースも考慮されており推奨されている方法

### Firebase Authentication SDK

ユーザ認証機能のみを提供する
  * メールとパスワード
  * フェデレーションIDプロバイダ
  * 電話番号認証
  * カスタム認証システム
    * 既存のログインシステムと連携して Firebase Realtime Database などと連携させることができる
  * 匿名認証
    * 一時的な匿名アカウントを作成
    * 通常のアカウントにアップグレードすることもできる

## 注意点

* 認証されたユーザは Firebase Realtime Database と Cloud Storage に対して、デフォルトでデータの読み取り、書き込みができる

## 用語

* フェデレーション：一度認証が通れば許可されているサービスを利用可能にする仕組み
  * ID連携、認証連携
* フェデレーションIDプロバイダ
  * Google, GitHub, Twitter, Facebook

## 疑問点
