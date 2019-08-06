# Firebase

## Firebase Authentication

* https://firebase.google.com/docs/auth

### 概要

ユーザ認証のための BaaS
iOS, Android, Webアプリケーションにおいてユーザ認証を実装するためのクライアントSDKとバックエンドサービスを提供する
OAuth 2.0 や OpenID Connect などの業界標準を使用している

### できること

#### FirebaseUI Auth

認証のための汎用的な UI とユーザ認証機能を提供する
エッジケースも考慮されており推奨されている方法

#### Firebase Authentication SDK

ユーザ認証機能のみを提供する
  * メールとパスワード
  * フェデレーションIDプロバイダ
  * 電話番号認証
  * カスタム認証システム
    * 既存のログインシステムと連携して Firebase Realtime Database などと連携させることができる
  * 匿名認証
    * 一時的な匿名アカウントを作成
    * 通常のアカウントにアップグレードすることもできる

#### Firebase Console

* ログインしたユーザの一覧が見れる
  * 識別子
  * プロバイダ
  * 作成日
  * ログイン日
  * ユーザーUID
* 該当ユーザの操作
  * パスワードを再設定
  * アカウントを無効にする
  * アカウントの削除

### 注意点

* 認証されたユーザは Firebase Realtime Database と Cloud Storage に対して、デフォルトでデータの読み取り、書き込みができる

### 用語

* フェデレーション：一度認証が通れば許可されているサービスを利用可能にする仕組み
  * ID連携、認証連携
* フェデレーションIDプロバイダ
  * Google, GitHub, Twitter, Facebook

### 疑問点

* サインアップできるユーザを制限する方法
  * 認可で制限する

## Database

以下の2種類が提供されている

* Cloud Firestore
* Realtime Database

https://firebase.google.com/docs/database/rtdb-vs-firestore

### Cloud Firestore

Firebase のモバイルアプリ開発用のデータベース。Realtime Database よりも直感的なデータモデルとなるように強化されている。
ほとんどのケースで Cloud Firestore の利用が推奨されている。

#### データモデル

NoSQL
データをドキュメントのコレクションとし保存する
  * シンプルなデータはドキュメントに保存するのが簡単
  * 複雑で階層的なデータについては、ドキュメント内のサブコレクションを使用することで大規模な整理を行うことができる
  * 非正規化とデータの平坦化が少なくて済む

https://firebase.google.com/docs/firestore/data-model

* ドキュメント
  * ストレージの単位
  * 各ドキュメントは名前で識別される
* マップ
  * ドキュメント内でネストされたオブジェクト
* コレクション
  * ドキュメントのコンテナ
    * 例：users
  * 作成したり、削除する必要はない
* サブコレクション
  * 特定のドキュメントに関連づけられたコレクション
  * 100 レベルまでネスト可能

### Realtime Database

リアルタイムのクライアント間同期が必要なモバイルアプリのためのデータベース。

#### データモデル

NoSQL
データを1つの大きな JSON ツリーとして保存する
  * シンプルなデータは非常に簡単に保存できる
  * 複雑で階層的なデータについては大規模な整理をするのが難しい
