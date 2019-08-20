# Database

以下の2種類が提供されている

* Cloud Firestore
* Realtime Database

https://firebase.google.com/docs/database/rtdb-vs-firestore

## Cloud Firestore

Firebase のモバイルアプリ開発用のデータベース。Realtime Database よりも直感的なデータモデルとなるように強化されている。
ほとんどのケースで Cloud Firestore の利用が推奨されている。

### データモデル

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

### 使用方法

https://firebase.google.com/docs/firestore/quickstart

## Realtime Database

リアルタイムのクライアント間同期が必要なモバイルアプリのためのデータベース。

### データモデル

NoSQL
データを1つの大きな JSON ツリーとして保存する
  * シンプルなデータは非常に簡単に保存できる
  * 複雑で階層的なデータについては大規模な整理をするのが難しい
