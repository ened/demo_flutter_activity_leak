#import "FlutterActivityPlugin.h"
#import <flutter_activity/flutter_activity-Swift.h>

@implementation FlutterActivityPlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  [SwiftFlutterActivityPlugin registerWithRegistrar:registrar];
}
@end
