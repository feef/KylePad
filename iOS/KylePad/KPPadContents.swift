//
//  KPPadContents.swift
//  KylePad
//
//  Created by sharif ahmed on 11/20/14.
//  Copyright (c) 2014 Feef. All rights reserved.
//

import UIKit
import AudioToolbox

class KPPadContents: NSObject {
    
    let soundID : SystemSoundID = 0
    let displayName : String = ""
    
    init(fileName : String, displayName : String) {
        self.displayName = displayName
        AudioServicesCreateSystemSoundID(CFURLCopyAbsoluteURL(NSURL(fileURLWithPath:  NSBundle.mainBundle().pathForResource(fileName, ofType: "mp3")!)), &soundID)
    }
    
    func play() {
        AudioServicesPlaySystemSound(soundID)
    }
    
    deinit {
        AudioServicesDisposeSystemSoundID(soundID)
    }
   
}
