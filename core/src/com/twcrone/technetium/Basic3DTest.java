package com.twcrone.technetium;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.*;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;

public class Basic3DTest implements ApplicationListener {
    private PerspectiveCamera camera;
    private ModelBatch modelBatch;
    private ModelBuilder modelBuilder;
    private Model sphere;
    private ModelInstance modelInstance;
    private Environment environment;

    private CameraInputController cameraInputController;
    private Model model;
    private ModelInstance instance;

    @Override
    public void create() {
        environment = new Environment();
        environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1));
        environment.add(new DirectionalLight().set(0.8f, 0.8f, 0.8f, -1, -0.8f, -0.2f));

        modelBatch = new ModelBatch();

        camera = new PerspectiveCamera(75, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.position.set(10, 10, 10);
        camera.lookAt(0,0,0);
        camera.near = 1;
        camera.far = 300;
        camera.update();

        cameraInputController = new CameraInputController(camera);
        Gdx.input.setInputProcessor(cameraInputController);

        model = new ModelBuilder().createSphere(5, 5, 5, 15, 15,
            new Material(ColorAttribute.createDiffuse(Color.BLUE)),
            VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal);
//        model = new ModelBuilder().createBox(5, 5, 5,
//                new Material(ColorAttribute.createDiffuse(Color.GREEN)),
//                VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal);
        instance = new ModelInstance(model);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        //Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

        modelBatch.begin(camera);
        modelBatch.render(instance, environment);
        modelBatch.end();

        cameraInputController.update();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {
        modelBatch.dispose();
        model.dispose();
    }
}
