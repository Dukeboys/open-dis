/**
 * This is an apple-style implementation of MVC, which differs in some
 * ways from the way other people define the pattern. See 
 * https://developer.apple.com/library/mac/#documentation/General/Conceptual/DevPedia-CocoaCore/MVC.html
 * for details. Briefly, models contain basic information and behaviors
 * such as position, views show the model contents to the user, and 
 * controllers tie the view to the model, so the two do not directly
 * refer to each other. This should allow us to use multiple model
 * loaders (collada, x3d, etc) in three.js, all tied to one underlying
 * model.
 */

// Namespace
if(nve === undefined)
{
    var nve = {};
};

nve.controllers = {};



nve.NveController = function( model, view )
{
    this.nvecontroller.model = model;
    this.view = view;
    nve.controllers[model.entityID] = this;
}

/** Model has changed; notify the view */
nve.modelChanged = function()
{
    
}

