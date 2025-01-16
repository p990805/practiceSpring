import React, { useRef, useEffect } from "react";
import { Canvas } from "@react-three/fiber";
import { OrbitControls, Sphere } from "@react-three/drei";
import * as THREE from "three";

function App() {
  return (
    <div style={{ height: "50vh", width: "50vw" }}>
      <Canvas>
        <ARVideoScene />
        <OrbitControls enableZoom={false} />
      </Canvas>
    </div>
  );
}

function ARVideoScene() {
  const videoRef = useRef();
  const textureRef = useRef();

  useEffect(() => {
    const video = document.createElement("video");
    video.src = "test.mp4"; // 360도 비디오 경로
    video.crossOrigin = "anonymous";
    video.loop = true;
    video.muted = true;
    video.play();

    const videoTexture = new THREE.VideoTexture(video);
    videoTexture.minFilter = THREE.LinearFilter;
    videoTexture.magFilter = THREE.LinearFilter;
    videoTexture.format = THREE.RGBFormat;

    textureRef.current = videoTexture;
    videoRef.current = video;
  }, []);

  return (
    <Sphere args={[5, 64, 64]} scale={[-1, 1, 1]}>
      {textureRef.current && (
        <meshBasicMaterial map={textureRef.current} side={THREE.DoubleSide} />
      )}
    </Sphere>
  );
}

export default App;
