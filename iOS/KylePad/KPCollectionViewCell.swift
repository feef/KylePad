//
//  KPCollectionViewCell.swift
//  KylePad
//
//  Created by sharif ahmed on 11/20/14.
//  Copyright (c) 2014 Feef. All rights reserved.
//

import UIKit

class KPCollectionViewCell: UICollectionViewCell {
    
    let label : UILabel = UILabel()

    required init(coder aDecoder: NSCoder) {
        super.init(coder: aDecoder)
        self.configure()
    }
    
    override init(frame: CGRect) {
        
        super.init(frame: frame)
        self.configure()
        
    }
    
    func configure() {
        label.frame = self.bounds
        label.text = ""
        label.textAlignment = NSTextAlignment.Center
        label.numberOfLines = 0
        self.contentView.addSubview(label)
        self.contentView.backgroundColor = UIColor.redColor()
        self.contentView.layer.cornerRadius = 8
    }
    
    func populateWithContents(padContents : KPPadContents) {
        label.text = padContents.displayName;
    }
    
}
