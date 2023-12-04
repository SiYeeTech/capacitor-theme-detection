import Foundation
import Capacitor

/**
 * Please read the Capacitor iOS Plugin Development Guide
 * here: https://capacitorjs.com/docs/plugins/ios
 */
@objc(ThemeDetectionPlugin)
public class ThemeDetectionPlugin: CAPPlugin {
    
    @objc func isDarkModeActive(_ call: CAPPluginCall) {
        var isDark: Bool = false
        
        if #available(iOS 13.0, *) {
            isDark = self.bridge?.userInterfaceStyle == .dark
        }
        
        call.resolve([
            "active": isDark
        ])
    }
}
