package org.kbalazs.native_helper.services;

import lombok.NonNull;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class RuntimeHintsReflectionGenerator
{
    public void configGenerator(List<String> packageNames, List<Class<?>> classes)
    {
        List<String> classNames = getClassNamesInPackages(packageNames, classes);
        classNames.forEach(System.out::println);
    }

    private static List<String> getClassNamesInPackages(
        @NonNull List<String> packageNames,
        @NonNull List<Class<?>> classes
    )
    {
        List<String> fqns = new ArrayList<>();

        classes.stream().map(Class::getName).forEach(fqns::add);

        packageNames.stream()
            .map(RuntimeHintsReflectionGenerator::getClassNamesInPackage)
            .flatMap(List::stream)
            .forEach(fqns::add);

        return fqns;
    }

    private static List<String> getClassNamesInPackage(@NonNull String packageName)
    {
        String path = "src/main/java/" + packageName.replace('.', '/');
        List<String> classNames = new ArrayList<>();

        try (Stream<Path> paths = Files.walk(Paths.get(path)))
        {
            paths
                .filter(Files::isRegularFile)
                .filter(p -> p.toString().endsWith(".java"))
                .forEach(p -> classNames.add(
                    packageName + "." + p.getFileName().toString().replace(".java", ".class")
                ));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return classNames;
    }
}
