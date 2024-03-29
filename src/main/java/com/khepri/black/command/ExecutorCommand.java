package com.khepri.black.command;

import com.khepri.black.filesystem.FileSystemService;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ExecutorCommand extends CommandImpl {
    @Override
    public Integer call() {
        if (getProperties() == null || getProperties().isEmpty()) {
            return 0;
        }

        List<String> command = new ArrayList<>();
        Properties properties = getProperties();
        command.add(properties.getProperty("executableFilePath"));

        getPositionalParameters().forEach(positionalParameter -> {
            if (positionalParameter.getValue() != null) {
                command.add((String) positionalParameter.getValue());
            }
        });

        getOptions().forEach(option -> {
            if (option.getValue() != null) {
                command.add((String) option.getValue());
            }
        });
        return FileSystemService.executeCommand(command);
    }
}
