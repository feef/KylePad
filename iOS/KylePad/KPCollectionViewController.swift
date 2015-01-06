//
//  KPCollectionViewController.swift
//  KylePad
//
//  Created by sharif ahmed on 11/20/14.
//  Copyright (c) 2014 Feef. All rights reserved.
//

import UIKit
import QuartzCore

let reuseIdentifier = "Cell"
let cellSeparation: CGFloat = 10

class KPCollectionViewController: UICollectionViewController {
    
    var sounds:[KPPadContents] = []
    
    override func viewWillAppear(animated: Bool) {
        super.viewWillAppear(animated)

        //Populate sounds array here
        
        let path = NSBundle.mainBundle().pathForResource("fileNames", ofType: "txt")
        var possibleContent = NSString(contentsOfFile: path!, encoding: NSUTF8StringEncoding, error: nil)
        if let content = possibleContent {
            var array = content.componentsSeparatedByString("\n")
            
            for fileName in array {
                if let fn = fileName as? NSString {
                    if fn == "" {
                        continue
                    }
                    sounds.append(KPPadContents(fileName: fn, displayName: fn))
                }
            }
            
            self.collectionView?.reloadData()
        }
        
    }

    override func viewDidLoad() {
        super.viewDidLoad()

        // Uncomment the following line to preserve selection between presentations
        // self.clearsSelectionOnViewWillAppear = false

        // Register cell classes
        self.collectionView?.registerClass(KPCollectionViewCell.self, forCellWithReuseIdentifier: reuseIdentifier)
        self.collectionView?.contentInset = UIEdgeInsetsMake(20 + cellSeparation, cellSeparation, cellSeparation, cellSeparation)

        // Do any additional setup after loading the view.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepareForSegue(segue: UIStoryboardSegue, sender: AnyObject!) {
        // Get the new view controller using [segue destinationViewController].
        // Pass the selected object to the new view controller.
    }
    */

    // MARK: UICollectionViewDataSource

    override func numberOfSectionsInCollectionView(collectionView: UICollectionView) -> Int {
        //#warning Incomplete method implementation -- Return the number of sections
        return 1
    }


    override func collectionView(collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        //#warning Incomplete method implementation -- Return the number of items in the section
        return sounds.count
    }

    override func collectionView(collectionView: UICollectionView, cellForItemAtIndexPath indexPath: NSIndexPath) -> UICollectionViewCell {
        let cell = collectionView.dequeueReusableCellWithReuseIdentifier(reuseIdentifier, forIndexPath: indexPath) as UICollectionViewCell
    
        // Configure the cell
    
        return cell
    }
    
    override func collectionView(collectionView: UICollectionView, willDisplayCell cell: UICollectionViewCell, forItemAtIndexPath indexPath: NSIndexPath) {
        
        (cell as KPCollectionViewCell).populateWithContents(sounds[indexPath.row])
        
    }
    
    override func collectionView(collectionView: UICollectionView, didSelectItemAtIndexPath indexPath: NSIndexPath) {
        
        sounds[indexPath.row].play();
        
    }

    // MARK: UICollectionViewDelegate

    /*
    // Uncomment this method to specify if the specified item should be highlighted during tracking
    func collectionView(collectionView: UICollectionView!, shouldHighlightItemAtIndexPath indexPath: NSIndexPath!) -> Bool {
        return true
    }
    */

    /*
    // Uncomment this method to specify if the specified item should be selected
    func collectionView(collectionView: UICollectionView!, shouldSelectItemAtIndexPath indexPath: NSIndexPath!) -> Bool {
        return true
    }
    */

    /*
    // Uncomment these methods to specify if an action menu should be displayed for the specified item, and react to actions performed on the item
    func collectionView(collectionView: UICollectionView!, shouldShowMenuForItemAtIndexPath indexPath: NSIndexPath!) -> Bool {
        return false
    }

    func collectionView(collectionView: UICollectionView!, canPerformAction action: String!, forItemAtIndexPath indexPath: NSIndexPath!, withSender sender: AnyObject!) -> Bool {
        return false
    }

    func collectionView(collectionView: UICollectionView!, performAction action: String!, forItemAtIndexPath indexPath: NSIndexPath!, withSender sender: AnyObject!) {
    
    }
    */

}
