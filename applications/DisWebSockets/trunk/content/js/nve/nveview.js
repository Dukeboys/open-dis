// Namespace
if(nve === undefined)
{
    var nve = {};
}

nve.colladaLoader = new THREE.ColladaLoader();

nve.entityTypeToGraphicDatabase = new Object();

// LAV/stryker model
nve.entityTypeToGraphicDatabase['{"entityKind":1,"domain":1,"country":225,"category":2,"subcategory":5,"spec":0,"extra":0}'] = '{"type": "collada", "modelPath":"colladaModels/models/stryker.dae", "scale":0.1}';
// M270 Multiple Launch Rocket System (MLRS)
nve.entityTypeToGraphicDatabase['{"entityKind":1,"domain":1,"country":225,"category":4,"subcategory":1,"spec":0,"extra":0}'] = '{"type": "collada","modelPath":"colladaModels/models/mlrs.dae", "scale": 0.1}';
nve.entityTypeToGraphicDatabase['defaultModel'] = '{"type": "collada", "modelPath":"cube/models/Cube.dae","scale":0.01}'; 

nve.NveView = function(graphicInformation)
{
 this.graphicsObject = {};
 this.graphicInformation = graphicInformation;
  
 //alert("Creating nve");
}
 
nve.NveView.prototype.load()
{
 if(graphicInformation.type == "collada")
 {
     nve.colladaLoader.load( 'colladaModels/models/stryker.dae', function(collada)
     {
         var dae = collada.scene;
         dae.scale.x = dae.scale.y = dae.scale.z = graphicInforation.scale;
         graphicsObject = collada.scene;

         scene.add(collada.scene);
         
         animate();
     });   
 }
}

nve.setPosition() = function()
{
    
}

nve.setOrientation() = function()
{
    
}

