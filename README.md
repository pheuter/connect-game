<p align="center">
  <img src="https://www.dropbox.com/s/mkejpada86to1g2/Logo.png?dl=1" width="350" />
  <br />
  <h3 align="center"><a href="https://medium.com/@markfayngersh/connect-lets-build-a-game-37620df1ddf7#.flgb8g5n6">Inaugural Blog Post</a></h3>
  <p align="center"><strong>A puzzle game written in ClojureScript using <a href="https://facebook.github.io/react-native/">React Native</a> and <a href="https://github.com/omcljs/om">Om.next</a></strong></p>
</p>

---

### Development

Most of these steps are taken straight out of the re-natal [README](https://github.com/drapanjanas/re-natal#creating-new-project), definitely worth checking out for more context.

#### Prerequisites

1. `$ brew install leiningen android-sdk`
2. `$ git clone https://github.com/pheuter/connect-game`
3. `$ cd connect-game && npm install`

May also want to check out the React Native [Getting Started](https://facebook.github.io/react-native/docs/getting-started.html) guide.

#### iOS

1. `$ re-natal use-figwheel`
2. `$ npm start`
3. `$ lein figwheel ios`
4. Start iOS app from XCode: `ios/ConnectGame.xcodeproj`

#### Android
1. `$ re-natal use-figwheel`
2. `$ npm start`
3. `$ lein figwheel android`
4. `$ react-native run-android`
