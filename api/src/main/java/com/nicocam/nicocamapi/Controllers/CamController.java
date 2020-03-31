package com.nicocam.nicocamapi.Controllers;

import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@RestController
@RequestMapping(path="/nicocam/api/cam")
public class CamController {
    @CrossOrigin
    @PostMapping()
    public @ResponseBody String RotateCam(@RequestParam("orientation") String orientation,
                                          @RequestParam("angle") int angle) throws IOException, InterruptedException {

        String[] cmd = {"python3", "rotate_cam.py", orientation};
        Process p = Runtime.getRuntime().exec(cmd);
        p.waitFor();

        /*String line = "", output = "";
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
        while ((line = br.readLine())!= null) {sb = sb.append(line).append("\n"); }

        output = sb.toString();
        System.out.println(output);*/

        return "cam rotated to " + orientation + " " + angle + " degrees";
    }

    @GetMapping()
    public @ResponseBody String RotateCam2(@RequestParam("orientation") String orientation,
                                           @RequestParam("angle") int angle)
    {
        return "hello";
    }

}



