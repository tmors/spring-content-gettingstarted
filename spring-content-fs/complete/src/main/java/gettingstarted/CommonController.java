package gettingstarted;

/**
 * @author pengyuxiang
 * @date 2018/12/21
 */

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CommonController {

    @RequestMapping(value="/videos/{pageId}", method = RequestMethod.GET)
    public List<VideoEntity> getCurrentVideoList(@PathVariable("pageId") Long id){
        VideoEntity videoEntity = new VideoEntity("title","url");
        List<VideoEntity>  videoEntities = new ArrayList<>();
        videoEntities.add(videoEntity);
        return videoEntities;
    }
}
