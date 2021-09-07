import 'package:flutter/material.dart';
import 'package:flutter_camera_module/camera.dart';

Future<void> main() async {
  WidgetsFlutterBinding.ensureInitialized();
  runApp(FullScreen());
}

@pragma('vm:entry-point')
Future<void> partialScreenEntryPoint() async {
  WidgetsFlutterBinding.ensureInitialized();
  runApp(PartialScreen());
}

class FullScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Flutter full screen widget',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: Scaffold(
        appBar: AppBar(
          title: Text('Flutter Module Widget'),
        ),
        body: CameraScreen(),
      ),
    );
  }
}

class PartialScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: Container(
        color: Colors.grey.shade200,
        height: 100.0,
        child: Scaffold(
          body: Center(
            child: CameraScreen(),
          ),
        ),
      ),
    );
  }
}
