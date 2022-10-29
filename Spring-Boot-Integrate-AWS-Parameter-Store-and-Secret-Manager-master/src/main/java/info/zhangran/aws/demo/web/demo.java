package info.zhangran.aws.demo.web;

import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.ssm.SsmClient;
import software.amazon.awssdk.services.ssm.model.CreateOpsItemRequest;
import software.amazon.awssdk.services.ssm.model.CreateOpsItemResponse;
import software.amazon.awssdk.services.ssm.model.SsmException;

/**
 * Before running this Java V2 code example, set up your development environment, including your credentials.
 *
 * For more information, see the following documentation topic:
 *
 * https://docs.aws.amazon.com/sdk-for-java/latest/developer-guide/get-started.html
 */
class CreateOpsItem {

    public static <String, Object> void main(String[] args) {

        final String USAGE = (String) ("\n" +
                        "Usage:\n" +
                        "    <title> <source> <category> <severity>\n\n" +
                        "Where:\n" +
                        "    title - The OpsItem title.\n" +
                        "    source - The origin of the OpsItem, such as Amazon EC2 or AWS Systems Manager.\n" +
                        "    category - A category to assign to an OpsItem.\n" +
                        "    severity - A severity to assign to an OpsItem.\n");

        if (args.length != 4) {
            System.out.println(USAGE);
            System.exit(1);
        }

        String title = args[0];
        String source = args[1];
        String category = args[2];
        String severity = args[3];

        Object northeast;
        Region region = Region.US_EAST_1;
        SsmClient ssmClient = SsmClient.builder()
                .region(region)
                .credentialsProvider(ProfileCredentialsProvider.create())
                .build();

        System.out.println("The Id of the OpsItem is " +createNewOpsItem(ssmClient, (java.lang.String) title, (java.lang.String) source, (java.lang.String) category, (java.lang.String) severity));
        ssmClient.close();
    }

    public static String createNewOpsItem( SsmClient ssmClient,
                                           String title,
                                           String source,
                                           String category,
                                           String severity) {

        try {
            CreateOpsItemRequest opsItemRequest = CreateOpsItemRequest.builder()
                    .description("Created by the SSM Java API")
                    .title(title)
                    .source(source)
                    .category(category)
                    .severity(severity)
                    .build();

            CreateOpsItemResponse itemResponse = ssmClient.createOpsItem(opsItemRequest);
            return itemResponse.opsItemId();

        } catch (SsmException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
        return "";
    }
}
