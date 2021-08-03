# Libgdx-Pixel-Perfect-Collision
A simple implementation to detect pixel perfect collision between two textures in libgdx. 

#Usage
  - TextureCollisionData class accepts a texture and texture dimensions size(dimensions size passed to the draw, optional if texture dimensions are kept default while drawing) and returns formatted texture as required by Collision class.
  - Collision class provides a static method PixelPerfectColl which returns true for collision and requires, two formatted textures(processed by TextureCollisionData Class), their current positions.
