// Namespace
if(nve === undefined)
{
    var nve = {};
}

// One type of mode loader
nve.colladaLoader = new THREE.ColladaLoader();

// Database of known entity types, and the collada models that correspond to the types
// If the entity type is unknown it can be replaced with a default model, a cube in this case.
// The "key" is the JSON of the entity type object, the value the path to the collada model

nve.entityTypeToGraphicDatabase = new Object();

// LAV/stryker model
nve.entityTypeToGraphicDatabase['{"entityKind":1,"domain":1,"country":225,"category":2,"subcategory":5,"spec":0,"extra":0}'] = '{"type": "collada", "modelPath":"colladaModels/models/stryker.dae", "scale":0.1}';
// M270 Multiple Launch Rocket System (MLRS)
nve.entityTypeToGraphicDatabase['{"entityKind":1,"domain":1,"country":225,"category":4,"subcategory":1,"spec":0,"extra":0}'] = '{"type": "collada","modelPath":"colladaModels/models/mlrs.dae", "scale": 0.1}';
nve.entityTypeToGraphicDatabase['defaultModel'] = '{"type": "collada", "modelPath":"cube/models/Cube.dae","scale":0.01}'; 

nve.entityDatabase = new Object();

/** Constructor */
nve.Entity = function(entityId, entityType)
{
    // The last time we heard from the entity
    this.timeLastHeardFrom = new Date();
    
    // Default scale size. The scale size should be set in the entityTypeToGraphicDatabase
    this.scale = 0.01;
    
    // How long we wait before we decide this entity is dead and remove it from the scene
    this.timeoutPeriod = 120000; // two min
    
    // The 3D model in the scene we're pushing around
    //this.collada = new GLGE.Collada();
    
    // Unique identifier for the entity--DIS convention of site, application, entityID
    this.entityId = entityId;
    
    // The EBV document/DIS entity type
    this.entityType = entityType;
    
    // The last entity state PDU received. Useful for dead reckoning.
    this.lastEspduReceived = undefined;
    
    
    this.cubeMaterialArray = [];
    // order to add materials: x+,x-,y+,y-,z+,z-
    this.cubeMaterialArray.push( new THREE.MeshBasicMaterial( { color: 0xff3333 } ) );
    this.cubeMaterialArray.push( new THREE.MeshBasicMaterial( { color: 0xff8800 } ) );
    this.cubeMaterialArray.push( new THREE.MeshBasicMaterial( { color: 0xffff33 } ) );
    this.cubeMaterialArray.push( new THREE.MeshBasicMaterial( { color: 0x33ff33 } ) );
    this.cubeMaterialArray.push( new THREE.MeshBasicMaterial( { color: 0x3333ff } ) );
    this.cubeMaterialArray.push( new THREE.MeshBasicMaterial( { color: 0x8833ff } ) );
    this.geometry = new THREE.CubeGeometry(20, 20, 20,1, 1, 1, this.cubeMaterialArray);
    //this.material = new THREE.MeshBasicMaterial({color:0xff0000, wireframe:true});
    this.mesh = new THREE.Mesh(this.geometry, new THREE.MeshFaceMaterial() );
    scene.add(this.mesh);
    
    
    // Look up the geoemetry/model for that entity type. If not found, use
    // a cube as a placeholder.
    
    /*
    this.model = nve.entityTypeToGraphicDatabase[this.entityType];
    
    if(this.model === undefined)
    {
        this.model = entityTypeToModelDatabase["default"]; 
        
        //this.collada.setScale(0.01);
    }
    
    var modelData = eval('(' + this.model + ')');
    
    //alert(modelData.type + " " + modelData.modelPath);
    
    if(modelData.type == "collada")
    {
       // alert("made it past test");
        
        nve.colladaLoader.load( modelData.modelPath, function colladaReady( collada )
        {
            //alert("loading collada model");

            // Grab the collada scene data:
            dae = collada.scene;

            // No skin applied to my model so no need for the following:
            // var skin = collada.skins[ 0 ];

            // Scale-up the model so that we can see it:
            dae.scale.x = dae.scale.y = dae.scale.z = modelData.scale;
            //
            //init();
            //animate();
        });
      
      alert(dae);
    */
       
}
/**
 * Returns true if the heartbeat period has expired, otherwise false.
 */
nve.Entity.prototype.expiredTime =  function()
{
    var now = new Date();

    if(now.getTime() - lastTimeHeardFrom.getTime() > timeoutPeriod)
    {
        return true;    
    }

    return false;
}   
    
 
/** Update the entity position with the newest espdu */
nve.Entity.prototype.updateEntity = function(espdu)
{
    // Save this for future use in dead reckoning
    this.lastEspduReceived = espdu;

    this.mesh.position.set(espdu.entityLocation.x, espdu.entityLocation.y, espdu.entityLocation.z);

}
