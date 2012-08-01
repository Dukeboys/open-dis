// Namespace
if(nve === undefined)
{
     var nve = {};
}

nve.espduPrototype = eval('(' + '{"protocolVersion":6,"exerciseID":0,"pduType":1,"protocolFamily":1,"timestamp":0,"pduLength":144,"padding":0,"entityID":{"site":0,"application":0,"entity":2},"forceId":0,"numberOfArticulationParameters":0,"entityType":{"entityKind":1,"domain":1,"country":225,"category":2,"subcategory":5,"spec":0,"extra":0},"alternativeEntityType":{"entityKind":0,"domain":0,"country":0,"category":0,"subcategory":0,"spec":0,"extra":0},"entityLinearVelocity":{"x":0.0,"y":0.0,"z":0.0},"entityLocation":{"x":6.800000000000003,"y":0.0,"z":5.0},"entityOrientation":{"psi":0.0,"theta":9.941592,"phi":0.0},"entityAppearance":0,"deadReckoningParameters":{"deadReckoningAlgorithm":0,"otherParameters":"AAAAAAAAAAAAAAAAAAAA","entityLinearAcceleration":{"x":0.0,"y":0.0,"z":0.0},"entityAngularVelocity":{"x":0.0,"y":0.0,"z":0.0}},"marking":{"characterSet":0,"characters":"AAAAAAAAAAAAAAA="},"capabilities":0,"articulationParameters":[]}' + ')');
 


// Initialize the web socket, and define various methods that are called
// on events such as an open, close, and, most importantly, a message.
nve.WebSocket = function (url)
{
    this.websocketUrl = url;
    console.log("Initializing websocket");
    
  // Note that we have to worry about Firefox brain damage; for who knows what reason they decicded
  // to change the name to "Mozwebsocket" instead of "websocket". Gah. The "window.WebSocket" variable
  // is already defined in compliant browsers; we check for that. If found, we assign actual functions
  // to the template object already present.
  
  // Compatiblity checks
  if(window.WebSocket)
      this.websocket = new WebSocket(this.websocketUrl, "nve");
   else if (window.MozWebSocket)
      this.websocket = new MozWebSocket(this.websocketUrl, "nve");
   else
   {
           console.log("Websockets not supported in this browser");
           return;
   }
  
  // Assign actual functions to the websocket object
  this.websocket.onopen = function(evt) { nve.WebSocket.prototype.onOpen(evt) };
  this.websocket.onclose = function(evt) { nve.WebSocket.prototype.onClose(evt) };
  this.websocket.onmessage = function(evt) { nve.WebSocket.prototype.onMessage(evt) };
  this.websocket.onerror = function(evt) { nve.WebSocket.prototype.onError(evt) };
}

/** Send a message to the server */
nve.WebSocket.prototype.send = function(message)
{
  this.websocket.send(message);
}

/** Callback called on the open event, when the websocket establishes a connection */
nve.WebSocket.prototype.onOpen = function(evt)
{
  console.log("CONNECTED websocket to " + this.websocketUrl);
}

/** Callback called when the websocket is closed */
nve.WebSocket.prototype.onClose = function(evt)
{
    console.log("DISCONNECTED websocket to " + this.websocketUrl );
}

/** Called when we receive a message from the server */
nve.WebSocket.prototype.onMessage = function(evt)
 {

    // Input text is in JSON format. Convert it to a javascript object
    var updateObject = eval('(' + evt.data + ')');
    //console.log(evt.data);
    
    // Entity type string
    var eTypeString = JSON.stringify(updateObject.entityType);
    
    // Entity ID string
    var eIdString = JSON.stringify(updateObject.entityID);
    
    // Retrieve the entity object from our list of known entities. If
    // the entity isn't in the list, we get an 'undefined' back and 
    // create the entity.
    var anEntity = nve.entityDatabase[eIdString];
    
    // This is the first time we've seen this EID? Add it to the scene graph
    // and add it to our entity list
    if(anEntity === undefined)
    {
        //var newView = new nvemodel.NveView(eTypeString);
        
        var newEntity =  new nve.Entity(eIdString, eTypeString);

        // Add entity to our list of entities
        nve.entityDatabase[eIdString] = newEntity;
        
        anEntity = newEntity;
        
        //for(var propName in nve.entityDatabase)
        //{
        //    console.log(propName);
        //}
    }
  
     anEntity.updateEntity(updateObject);
 }
 

