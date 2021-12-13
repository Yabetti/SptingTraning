# SptingTraning
Spring boot × Gradle でサイト作成

2021/12/13 Start



















～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～
メモ
■TYMELEAF
　th:include="sendMessage :: commonMessage"
 上記でcommonMessage.htmlを呼び出す。呼び出し元としては、sendMessageが属性となるので、#sendMessageとかで指定してJSで操作できる。
　例えば、ボタン押下時にモーダル呼び出したり、同じデザインの画面のメインコンテンツのみ入れ替えたりできる。

■Java
 ■Spring
　　■アノテーション
　　　■@Controllerと@RestControllerの違い
　　　　@Controllerは主にWebページ用のコントローラで使用する。
　　　　Webページ用コントローラはJSPやテンプレートエンジンのViewに遷移してレスポンスのHTMLを生成するので、基本的にメソッドの戻り値はViewの遷移先を指定するのに使用する。
　　　　@RestControllerはJsonやXML等を返すWebAPI用のコントローラで使用する。
　　　　こちらはViewに遷移しないのでメソッドの戻り値はレスポンスのコンテンツになる。
　　■キャッシュバスティング
　　　JSやhtmlなどの読み込みファイルをブラウザが保持しているキャッシュから読みこむことがある。(サーバからレンタリングしない)
　　　アプリリリース後、ユーザから画面が更新されていないなどの問い合わせ対策として、ファイルを都度読み込めるように対応する事。
　　　-キャッシュの有効期限や、更新時のversionを付与したり、ランタイムな番号をファイルのURLとして付与すると、都度読み込まれる。
　
～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～
□Spring構築(Gradle)



