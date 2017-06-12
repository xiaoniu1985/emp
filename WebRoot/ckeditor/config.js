/**
 * @license Copyright (c) 2003-2017, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see LICENSE.md or http://ckeditor.com/license
 */

CKEDITOR.editorConfig = function( config ) {
	// Define changes to default configuration here. For example:
    config.language = 'zh-cn';
    config.uiColor = '#AADC6E';
	config.width = 800;
    config.height = 400;
    config.resize_enabled = false;
    config.enterMode = CKEDITOR.ENTER_BR;  
    config.shiftEnterMode = CKEDITOR.ENTER_P;
    config.toolbar = 'MyToolbar';
    
    
    config.toolbar_MyToolbar =
        
[
 { name: 'document', items : [ 'Source','-','Save','NewPage','DocProps','Preview','Print','-','Templates' ] },
 { name: 'clipboard', items : [ 'Cut','Copy','Paste','PasteText','PasteFromWord','-','Undo','Redo'] },
 '/',
{ name:'paragraph', items :['JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock','-', 'Bold','Italic','Underline','Strike','TextColor','BGColor','Maximize','ShowBlocks'  ] },
'/',
 { name: 'styles', items : [ 'Styles','Format','Font','FontSize' ] },
];
};



